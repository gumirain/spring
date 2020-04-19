package mrs.app.room;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mrs.domain.model.ReservableRoom;
import mrs.domain.service.room.RoomService;

@Controller
@RequestMapping("rooms")
public class RoomsController {
	@Autowired
	RoomService roomService;

	@RequestMapping(method = RequestMethod.GET)
	String listRooms(Model model) {
		//本日の日付を取得する。
		LocalDate today = LocalDate.now();
		//対象の日付で予約可能な会議室一覧を取得する。
		List<ReservableRoom> rooms = roomService.findReservableRooms(today);
		//画面に渡す情報をModelオブジェクトに設定する。
		model.addAttribute("date", today);
		model.addAttribute("rooms", rooms);
		return "room/listRooms";
	}

}
