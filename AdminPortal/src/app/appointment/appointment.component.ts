import { Component, OnInit } from '@angular/core';
import {AppointmentService} from '../appointment.service';


@Component({
  selector: 'app-appointment',
  templateUrl: './appointment.component.html',
  styleUrls: ['./appointment.component.css']
})
export class AppointmentComponent implements OnInit {

  appointmentList: Object[];

	constructor(private appointmentService: AppointmentService) {
		this.getAppointmentList();
	}

	getAppointmentList() {
		this.appointmentService.getAppointmentList().subscribe(
			res => {
        		this.appointmentList = JSON.parse(JSON.parse(JSON.stringify(res))._body);
      		},
      		error => console.log(error)
		)
	}	

	confirmAppointment(id: number) {
  		this.appointmentService.confirmAppointment(id).subscribe();
  		location.reload();
  	}

ngOnInit() {}
}
