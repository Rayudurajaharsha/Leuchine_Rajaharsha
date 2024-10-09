package com.cda.college_direc.util;

import com.cda.college_direc.model.Role;

public class RoleUtil {

    public static boolean isValidRole(String role) {
        try {
            Role.valueOf(role.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}