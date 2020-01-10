import { University } from './../../../../../core/models/Purchase/university';
import { UniversityService } from './../../../../../core/services/Purchase/university.service';
import { Component, OnInit } from '@angular/core';
import { NzModalRef, NzMessageService } from 'ng-zorro-antd';
import { AuthLvlAddModalComponent } from '../../../authorize-lvl/components/auth-lvl-add-modal/auth-lvl-add-modal.component';

@Component({
  selector: 'app-uni-add-modal',
  templateUrl: './uni-add-modal.component.html',
  styleUrls: ['./uni-add-modal.component.less']
})
export class UniAddModalComponent implements OnInit {

	university: University = new University();
  constructor(private uniService: UniversityService,
		private modalRef: NzModalRef<AuthLvlAddModalComponent>,
		private message: NzMessageService) { }

  ngOnInit() {
	}

	saveUniversity(){
		// console.log(this.authLvl);
		this.uniService.saveUniversity(this.university).subscribe(
			data => {
				// console.log(data['status']+"data");
				this.message.create('success', `University Successfully Added!`,{nzDuration:3000});
				this.modalRef.triggerOk();
			},
			error => {
				// console.log(error['status']+"error");
				// console.log(error);
				// this.message.create('success', `Authorize Level Successfully Added!`);
				this.message.create('error', `University Not Added!`,{nzDuration:3000});
			}
		);

		// this.modalRef.close();

}
onCancel() {
	this.modalRef.triggerCancel();
}

}
