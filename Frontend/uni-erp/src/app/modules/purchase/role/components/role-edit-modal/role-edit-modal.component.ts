import { RoleService } from './../../../../../core/services/Purchase/role.service';
import { Component, OnInit, Input } from '@angular/core';
import { Role } from 'src/app/core/models/Purchase/role';
import { NzModalRef, NzMessageService } from 'ng-zorro-antd';
import { AuthLvlAddModalComponent } from '../../../authorize-lvl/components/auth-lvl-add-modal/auth-lvl-add-modal.component';
import { PermissionService } from 'src/app/core/services/Purchase/permission.service';

@Component({
  selector: 'app-role-edit-modal',
  templateUrl: './role-edit-modal.component.html',
  styleUrls: ['./role-edit-modal.component.less']
})
export class RoleEditModalComponent implements OnInit {

	@Input() rol: Role;
	permissions: any = [];
  constructor(private roleService: RoleService,
		private modalRef: NzModalRef<AuthLvlAddModalComponent>,
		private message: NzMessageService,
		private permissionService: PermissionService) { }

  ngOnInit() {
		this.getAllPermission();
  }

	onCancel() {
		this.modalRef.triggerCancel();
	}

	updateRole(){
		this.roleService.updateRole(this.rol.id, this.rol).subscribe(
			data => {
				this.message.create('success', `Role Updated Successfully!`,{nzDuration:3000});
				// console.log(JSON.parse(JSON.stringify(this.authLvl)))
				this.modalRef.triggerOk();
			},
			error => {
				this.message.create('error', `Role Not Updated!`,{nzDuration:3000});
			}
		);

		// this.modalRef.close();
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
