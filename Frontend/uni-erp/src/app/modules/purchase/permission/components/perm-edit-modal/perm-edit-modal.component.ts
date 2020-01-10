import { Component, OnInit, Input } from '@angular/core';
import { Permission } from 'src/app/core/models/Purchase/permission';
import { PermissionService } from 'src/app/core/services/Purchase/permission.service';
import { NzModalRef, NzMessageService } from 'ng-zorro-antd';
import { AuthLvlAddModalComponent } from '../../../authorize-lvl/components/auth-lvl-add-modal/auth-lvl-add-modal.component';

@Component({
  selector: 'app-perm-edit-modal',
  templateUrl: './perm-edit-modal.component.html',
  styleUrls: ['./perm-edit-modal.component.less']
})
export class PermEditModalComponent implements OnInit {

	@Input() permis: Permission;
  constructor(private permissionService: PermissionService,
		private modalRef: NzModalRef<AuthLvlAddModalComponent>,
		private message: NzMessageService) { }

  ngOnInit() {
	}
	onCancel() {
		this.modalRef.triggerCancel();
	}

	updatePermission(){
		this.permissionService.updatePermission(this.permis.id, this.permis).subscribe(
			data => {
				this.message.create('success', `Permission Updated Successfully!`,{nzDuration:3000});
				// console.log(JSON.parse(JSON.stringify(this.authLvl)))
				this.modalRef.triggerOk();
			},
			error => {
				this.message.create('error', `Permission Not Updated!`,{nzDuration:3000});
			}
		);

		// this.modalRef.close();
	}

}
