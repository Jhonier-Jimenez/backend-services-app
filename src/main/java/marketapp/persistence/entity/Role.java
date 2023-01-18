package marketapp.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role {

    //----------------TABLE COLUMNS-------------------------

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer roleID;

    @Enumerated(value = EnumType.STRING)
    private RoleList roleList;

    //----------------RELATIONSHIPS--------------------------

    @OneToMany(mappedBy = "role")
    private List<Client> clientList;

    //----------------GETTERS & SETTERS--------------------------


    public Integer getRoleID() {
        return roleID;
    }

    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }

    public RoleList getRoleList() {
        return roleList;
    }

    public void setRoleList(RoleList roleList) {
        this.roleList = roleList;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }
}
