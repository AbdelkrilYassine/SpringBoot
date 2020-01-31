package tn.project.manage.common;

public class Role {
	
    private RoleName name;
 
    public Role() {}
 
    public Role(RoleName name) {
        this.name = name;
    }
 
    public RoleName getName() {
        return name;
    }
 
    public void setName(RoleName name) {
        this.name = name;
    }
}
