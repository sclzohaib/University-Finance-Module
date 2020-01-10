import { RoleService } from './../../../../../core/services/Purchase/role.service';
import { Component, OnInit } from '@angular/core';
import { Role } from 'src/app/core/models/Purchase/role';
import { PermissionService } from 'src/app/core/services/Purchase/permission.service';
import { NzModalRef, NzMessageService } from 'ng-zorro-antd';
import { AuthLvlAddModalComponent } from '../../../authorize-lvl/components/auth-lvl-add-modal/auth-lvl-add-modal.component';
import { Permission } from 'src/app/core/models/Purchase/permission';

@Component({
  selector: 'app-role-add-modal',
  templateUrl: './role-add-modal.component.html',
  styleUrls: ['./role-add-modal.component.less']
})
export class RoleAddModalComponent implements OnInit {

	permissions: any = [];
	role: Role = new Role();
  constructor(private modalRef: NzModalRef<AuthLvlAddModalComponent>,
		private message: NzMessageService,
		private roleService: RoleService,
		private permissionService: PermissionService) { }

  ngOnInit() {
		this.getAllPermission();
  }

	saveRole(){
		// console.log(this.minorHead);
		this.roleService.saveRole(this.role).subscribe(
			data => {
				// console.log(data['status']+"data");
				this.message.create('success', `Role Successfully Added!`,{nzDuration:3000});
				this.modalRef.triggerOk();
			},
			error => {
				// console.log(error['status']+"error");
				// console.log(error);
				// this.message.create('success', `Authorize Signatory Successfully Added!`);
				this.message.create('error', `Role Not Added!`,{nzDuration:3000});
			}
		);

		// this.modalRef.close();

}
onCancel() {
	this.modalRef.triggerCancel();
}

public getAllPermission(){
	this.permissionService.getAllPermission().subscribe(
			data => {
					this.permissions = data;


			},
			error => {

				if(error['status']=='404'){
					this.permissions = [];
				}
					else if(error.error){
					this.permissions = error.error;
			}



			}
	);
}

}
