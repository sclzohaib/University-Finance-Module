import { UniversityService } from './../../../../../core/services/Purchase/university.service';
import { Component, OnInit, Input } from '@angular/core';
import { University } from 'src/app/core/models/Purchase/university';
import { NzModalRef, NzMessageService } from 'ng-zorro-antd';
import { AuthLvlAddModalComponent } from '../../../authorize-lvl/components/auth-lvl-add-modal/auth-lvl-add-modal.component';

@Component({
  selector: 'app-uni-edit-modal',
  templateUrl: './uni-edit-modal.component.html',
  styleUrls: ['./uni-edit-modal.component.less']
})
export class UniEditModalComponent implements OnInit {

	@Input() uni: University;

  constructor(private uniService: UniversityService,
		private modalRef: NzModalRef<AuthLvlAddModalComponent>,
		private message: NzMessageService) { }

  ngOnInit() {
  }

	onCancel() {
		this.modalRef.triggerCancel();
	}

	updateUniversity(){
		this.uniService.updateUniversity(this.uni.id, this.uni).subscribe(
			data => {
				this.message.create('success', `University Updated Successfully!`,{nzDuration:3000});
				// console.log(JSON.parse(JSON.stringify(this.authLvl)))
				this.modalRef.triggerOk();
			},
			error => {
				this.message.create('error', `University Not Updated!`,{nzDuration:3000});
			}
		);

		// this.modalRef.close();
	}

}
