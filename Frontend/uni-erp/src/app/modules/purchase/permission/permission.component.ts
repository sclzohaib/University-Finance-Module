import { Component, OnInit } from '@angular/core';
import { NzModalService, NzMessageService } from 'ng-zorro-antd';
import { PermAddModalComponent } from './components/perm-add-modal/perm-add-modal.component';
import { PermEditModalComponent } from './components/perm-edit-modal/perm-edit-modal.component';
import { PermissionService } from 'src/app/core/services/Purchase/permission.service';
import { Permission } from 'src/app/core/models/Purchase/permission';

@Component({
  selector: 'app-permission',
  templateUrl: './permission.component.html',
  styleUrls: ['./permission.component.less']
})
export class PermissionComponent implements OnInit {

	permissions: any = [];
	loading: boolean = false;
	constructor(private modalSvc: NzModalService, private permissionService: PermissionService,
		private message: NzMessageService) { }

  ngOnInit() {
		this.getAllPermission();
  }
  onModalCancel() {
		this.getAllPermission();
	}
	onAdd() {
		const modal = this.modalSvc.create({
			nzTitle: "Add Permission",
			nzContent: PermAddModalComponent,
			nzOnCancel: this.onModalCancel.bind(this),
			nzOnOk: this.onModalCancel.bind(this),
			nzComponentParams: {

			},
			nzFooter: null
		});
		// modal.afterClose.subscribe(this.afterAdd);
	}

	onEdit(permission: Permission) {
		const modal = this.modalSvc.create({
			nzTitle: "Edit Permission",
			nzContent: PermEditModalComponent,
			nzOnCancel: this.onModalCancel.bind(this),
			nzOnOk: this.onModalCancel.bind(this),
			nzComponentParams: {
				permis: permission
			},
			nzFooter: null
		});
		// modal.afterClose.subscribe(this.afterEdit);
	}

	public getAllPermission(){
		this.permissionService.getAllPermission().subscribe(
				data => {
						this.permissions = data;
						// console.log("data")


				},
				error => {
					// console.log("error")
					if(error['status']=='404'){
						this.permissions = [];
					}
						else if(error.error){
						this.permissions = error.error;
				}

					else{
						this.loading = true;
					}

				}
		);
	}

	public deletePermission(id: number){
		this.permissionService.deletePermission(id).subscribe(
			data =>{
				this.message.create('success', `Permission Deleted Successfully!`);
				this.getAllPermission();
			},
			error=> {
				this.message.create('error', `Permission Not Deleted!`);
				this.getAllPermission();
			}
		);

	}
}
