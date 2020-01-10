import { Component, OnInit } from '@angular/core';
import { PermissionService } from 'src/app/core/services/Purchase/permission.service';
import { Permission } from 'src/app/core/models/Purchase/permission';
import { NzModalRef, NzMessageService } from 'ng-zorro-antd';
import { AuthLvlAddModalComponent } from '../../../authorize-lvl/components/auth-lvl-add-modal/auth-lvl-add-modal.component';

@Component({
  selector: 'app-perm-add-modal',
  templateUrl: './perm-add-modal.component.html',
  styleUrls: ['./perm-add-modal.component.less']
})
export class PermAddModalComponent implements OnInit {

	permission: Permission = new Permission();
  constructor(private permissionService: PermissionService,
		private modalRef: NzModalRef<AuthLvlAddModalComponent>,
		private message: NzMessageService) { }

  ngOnInit() {
	}
	savePermission(){
		// console.log(this.authLvl);
		this.permissionService.savePermission(this.permission).subscribe(
			data => {
				// console.log(data['status']+"data");
				this.message.create('success', `Permission Successfully Added!`,{nzDuration:3000});
				this.modalRef.triggerOk();
			},
			error => {
				// console.log(error['status']+"error");
				// console.log(error);
				// this.message.create('success', `Authorize Level Successfully Added!`);
				this.message.create('error', `Permission Not Added!`,{nzDuration:3000});
			}
		);

		// this.modalRef.close();

}
onCancel() {
	this.modalRef.triggerCancel();
}

}
