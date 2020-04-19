package mrs.domain.model;

import java.io.Serializable;
import java.time.LocalTime;
import javax.persistence.*;

@Entity
public class Reservation implements Serializable{

	@Id
	//主キーをJPAに自動採番させる。
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer reservationId;
	private LocalTime startTime;
	private LocalTime endTime;

	//ReservableRoomエンテティと1方向の多対１の関連設定を行う。外部キーとしてreserved_dateとroom_idの複合キーを指定する。
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "reserved_date"),
		  @JoinColumn(name = "room_id")})
	private ReservableRoom reservabeRoom;

	//Userエンテティと1方向の多対１の関連設定を行う。外部キーとしてuser_idを指定する。
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Integer getReservationId() {
		return reservationId;
	}

	public void setReservationId(Integer reservationId) {
		this.reservationId = reservationId;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public ReservableRoom getReservabeRoom() {
		return reservabeRoom;
	}

	public void setReservabeRoom(ReservableRoom reservabeRoom) {
		this.reservabeRoom = reservabeRoom;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
