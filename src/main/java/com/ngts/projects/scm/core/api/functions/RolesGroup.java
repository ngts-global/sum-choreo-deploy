package com.ngts.projects.scm.core.api.functions;

import java.util.List;

public class RolesGroup {

    private String roleName;
    private List<Functions> functionsList;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<Functions> getFunctionsList() {
        return functionsList;
    }

    public void setFunctionsList(List<Functions> functionsList) {
        this.functionsList = functionsList;
    }
}
