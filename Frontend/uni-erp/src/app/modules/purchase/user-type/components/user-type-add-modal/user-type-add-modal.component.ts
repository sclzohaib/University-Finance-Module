import { UserTypeService } from './../../../../../core/services/Purchase/user-type.service';
import { Component, OnInit } from '@angular/core';
import { UserType } from 'src/app/core/models/Purchase/user-type';
import { NzModalRef, NzMessageService } from 'ng-zorro-antd';
import { AuthLvlAddModalComponent } from '../../../authorize-lvl/components/auth-lvl-add-modal/auth-lvl-add-modal.component';

@Component({
  selector: 'app-user-type-add-modal',
  templateUrl: './user-type-add-modal.component.html',
  styleUrls: ['./user-type-add-modal.component.less']
})
export class UserTypeAddModalComponent implements OnInit {

	userType: UserType = new UserType();
  constructor(private userTypeService: UserTypeService,
		private modalRef: NzModalRef<AuthLvlAddModalComponent>,
		private message: NzMessageService) { }

  ngOnInit() {
	}

	saveUserType(){
		// console.log(this.authLvl);
		this.userTypeService.saveUserType(this.userType).subscribe(
			data => {
				// console.log(data['status']+"data");
				this.message.create('success', `User Type Successfully Added!`,{nzDuration:3000});
				this.modalRef.triggerOk();
			},
			error => {
				// console.log(error['status']+"error");
				// console.log(error);
				// this.message.create('success', `Authorize Level Successfully Added!`);
				this.message.create('error', `User Type Not Added!`,{nzDuration:3000});
			}
		);

		// this.modalRef.close();

}
onCancel() {
	this.modalRef.triggerCancel();
}

}
