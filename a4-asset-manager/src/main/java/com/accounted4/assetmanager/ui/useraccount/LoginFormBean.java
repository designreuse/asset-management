package com.accounted4.assetmanager.ui.useraccount;

import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author gheinze
 */
@Data
public class LoginFormBean {

    @NotNull private String userAccount;
    private String password;
}
