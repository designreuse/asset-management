package com.accounted4.assetmanager.ui.useraccount;

import com.vaadin.server.Page;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.MenuBar;
import javax.annotation.PostConstruct;

/**
 *
 * @author gheinze
 */
@SpringComponent
@UIScope
public class UserSessionMenu extends MenuBar {


    private static final long serialVersionUID = 1L;

    private static final String LOGOUT = "Logout";


    @PostConstruct
    private void init() {
        // A session may already exist if we are opening a new tab...
        enableLogout();
    }


    private final Command logoutCommand = (final MenuItem selectedItem) -> {
        Page.getCurrent().setLocation("/");
        VaadinSession.getCurrent().getSession().invalidate();
    };


    public void enableLogout() {
        VaadinSession vaadinSession = VaadinSession.getCurrent();
        if (null != vaadinSession) {
            UserSession userSession = (UserSession) vaadinSession.getAttribute(UserSession.USER_SESSION_KEY);
            if (null != userSession) {
                MenuBar.MenuItem userMenuItem = addItem(userSession.getDisplayName(), null, null);
                userMenuItem.addItem(LOGOUT, logoutCommand);
            }
        }
    }

}
