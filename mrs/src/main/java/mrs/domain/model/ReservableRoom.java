package mrs.domain.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class ReservableRoom implements Serializable{
	//複合主キーを扱うために複合主キークラスであるReservableRoomIdを用意して@EmbeddedIdアノテーションを付与する。
	@EmbeddedId
	private ReservableRoomId reservableRoomId;

	//MeetingRoomエンテティと1方向の多対１の関連設定を行う。外部キーとしてroom_idを指定する。
	//ただし、このフィールドは関連を表すためだけに存在し、実際のroom_idに対応するフィールドはReservableRoomIdクラスが持つ。
	//そのため、このフィールドの対する値の変更がデータベースに反映されないようにinsertable属性およびupdatable属性にfalseを設定する。
	@ManyToOne
	@JoinColumn(name = "room_id", insertable = false, updatable = false)
	//MapsIdに複合クラスのうち、外部キーとして使うフィールド名を指定する。
	//ReservableRoomIdは、roomIdとreservedDateフィールドによる複合クラスである。
	@MapsId("roomId")
	private MeetingRoom meetingRoom;

	public ReservableRoom(ReservableRoomId reservableRoomId) {
		this.reservableRoomId = reservableRoomId;
	}

	public ReservableRoom() {

	}

	public ReservableRoomId getReservableRoomId() {
		return reservableRoomId;
	}

	public void setReservableRoomId(ReservableRoomId reservableRoomId) {
		this.reservableRoomId = reservableRoomId;
	}

	public MeetingRoom getMeetingRoom() {
		return meetingRoom;
	}

	public void setMeetingRoom(MeetingRoom meetingRoom) {
		this.meetingRoom = meetingRoom;
	}

}
