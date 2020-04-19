package mrs.domain.repository.room;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mrs.domain.model.ReservableRoom;
import mrs.domain.model.ReservableRoomId;


//JpaRepositryインターフェースを継承してReservableRoomエンテティ用のリポジトリインターフェースを作成する。
//型パラメーターにReservableRoomクラスとその主キークラスであるReservableRoomIdクラスを指定する。
public interface ReservableRoomRepository extends JpaRepository<ReservableRoom, ReservableRoomId> {

	//指定日に予約可能な会議室の一覧を取得するメソッドを定義する。日付を指定してreservable_rromテーブルから
	//room_idの昇順でデータを取得する。Spring Data JPAの命名規約でメソッド名を作成する。ネストしたクラスの
	//フィールドを指定する場合は「_」を使うため↓のような形式となる。
	List<ReservableRoom> findByReservableRoomId_reservedDateOrderByReservableRoomId_roomIdAsc(LocalDate reservedDate);
}

