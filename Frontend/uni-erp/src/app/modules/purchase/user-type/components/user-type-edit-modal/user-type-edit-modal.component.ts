import { UserTypeService } from './../../../../../core/services/Purchase/user-type.service';
import { Component, OnInit, Input } from '@angular/core';
import { UserType } from 'src/app/core/models/Purchase/user-type';
import { NzModalRef, NzMessageService } from 'ng-zorro-antd';
import { AuthLvlAddModalComponent } from '../../../authorize-lvl/components/auth-lvl-add-modal/auth-lvl-add-modal.component';

@Component({
  selector: 'app-user-type-edit-modal',
  templateUrl: './user-type-edit-modal.component.html',
  styleUrls: ['./user-type-edit-modal.component.less']
})
export class UserTypeEditModalComponent implements OnInit {

  @Input() usrType: UserType;
  constructor(private userTypeService: UserTypeService,
		private modalRef: NzModalRef<AuthLvlAddModalComponent>,
		private message: NzMessageService) { }

  ngOnInit() {
	}

	onCancel() {
		this.modalRef.triggerCancel();
	}

	updateUserType(){
		this.userTypeService.updateUserType(this.usrType.id, this.usrType).subscribe(
			data => {
				this.message.create('success', `User Type Updated Successfully!`,{nzDuration:3000});
				// console.log(JSON.parse(JSON.stringify(this.authLvl)))
				this.modalRef.triggerOk();
			},
			error => {
				this.message.create('error', `User Type Not Updated!`,{nzDuration:3000});
			}
		);

		// this.modalRef.close();
	}
}
