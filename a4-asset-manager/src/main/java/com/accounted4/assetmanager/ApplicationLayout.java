package com.accounted4.assetmanager;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalLayout;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * A Layout for the Application:
 *   o A "Header" area with a logo which pops up an "about" dialog
 *   o The "Main" area which contains a menu on the left and the content of selected menu item on the right
 *   o A "Footer" area
 * @author gheinze
 */
@SpringComponent
@UIScope
public class ApplicationLayout extends VerticalLayout {

    private Panel mainContentArea;

    @Autowired private AboutContent aboutContent;


    @PostConstruct
    public void init() {
        addHeader();
        addMain();
        addFooter();
    }


    private void addHeader() {

        HorizontalLayout header  = new HorizontalLayout();
        header.setWidth("100%");
        header.setHeight("32px");

        Label initialSpacer = new Label(" ");
        initialSpacer.setWidth("10px");
        initialSpacer.setHeight(null);
        header.addComponent(initialSpacer);

        header.addComponents(aboutContent.getInvokingButton(), aboutContent.getAboutPopupView());
        header.setStyleName("appHeader");
        header.setComponentAlignment(aboutContent.getInvokingButton(), Alignment.MIDDLE_LEFT);

        Label extraSpaceAbsorber = new Label(" ");
        header.addComponent(extraSpaceAbsorber);
        header.setExpandRatio(extraSpaceAbsorber, 1.0f);

        Panel headerPanel = new Panel();
        headerPanel.setHeightUndefined();
        headerPanel.setWidth(100, Unit.PERCENTAGE);
        headerPanel.setContent(header);

        addComponent(headerPanel);

    }


    private void addMain() {
        HorizontalSplitPanel mainArea = new HorizontalSplitPanel();
        mainArea.setFirstComponent(createMainAreaMenu());
        mainArea.setSecondComponent(createMainAreaContentPanel());
        mainArea.setSplitPosition(10, Unit.PERCENTAGE);
        mainArea.setSizeFull();
        mainArea.setHeight("100%");
        addComponent(mainArea);
        setExpandRatio(mainArea, 1.0f);
    }

    private void addFooter() {
        HorizontalLayout footer  = new HorizontalLayout();
        addComponent(footer);
    }

    private Component createMainAreaMenu() {
        Tree menu = new Tree();
        return menu;
    }

    private Component createMainAreaContentPanel() {
        mainContentArea = new Panel();
        mainContentArea.setSizeFull();
        return mainContentArea;
    }


    public void setMainArea(Component component) {
        mainContentArea.setContent(component);
    }

}
