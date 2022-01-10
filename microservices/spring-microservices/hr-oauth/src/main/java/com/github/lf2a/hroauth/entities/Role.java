package com.github.lf2a.hroauth.entities;

import java.io.Serializable;

/**
 * <h1>Role.java</h1>
 * ---
 *
 * @author Luiz Filipy
 * @version 1.0
 * @since 05/04/2021
 */
public class Role implements Serializable {

    private Long id;
    private String roleName;

    public Role() {
    }

    public Role(Long id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
