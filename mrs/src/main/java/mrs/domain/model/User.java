package mrs.domain.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
//Tableアノテーションを付与してマッピング先のテーブル名を取得する
@Table(name = "user")
public class User implements Serializable {

	@Id
    private String userId;
	private String password;
	private String firstName;
	private String lastName;

    //Enumeratedアノテーションを付与して、ユーザー権限をEnumにマッピングする。カラムの値にEnumの
	//文字列表現が格納されるように、EnumType.STRINGを指定している。
	@Enumerated(EnumType.STRING)
	private RoleName roleName;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public RoleName getRoleName() {
		return roleName;
	}

	public void setRoleName(RoleName roleName) {
		this.roleName = roleName;
	}
}
