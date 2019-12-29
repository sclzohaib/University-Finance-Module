import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgZorroAntdModule } from 'ng-zorro-antd';
import { PurchaseRoutingModule } from './purchase-routing.module';
import { PermissionComponent } from './permission/permission.component';
import { RoleComponent } from './role/role.component';
import { UserComponent } from './user/user.component';
import { DepartmentComponent } from './department/department.component';
import { UniversityComponent } from './university/university.component';
import { AuthorizeSignatoryComponent } from './authorize-signatory/authorize-signatory.component';
import { AuthorizeLvlComponent } from './authorize-lvl/authorize-lvl.component';
import { MajorHeadComponent } from './major-head/major-head.component';
import { MinorHeadComponent } from './minor-head/minor-head.component';
import { GrnComponent } from './grn/grn.component';
import { AuthLvlAddModalComponent } from './authorize-lvl/components/auth-lvl-add-modal/auth-lvl-add-modal.component';
import { AuthLvlEditModalComponent } from './authorize-lvl/components/auth-lvl-edit-modal/auth-lvl-edit-modal.component';
import { AuthSignAddModalComponent } from './authorize-signatory/components/auth-sign-add-modal/auth-sign-add-modal.component';
import { AuthSignEditModalComponent } from './authorize-signatory/components/auth-sign-edit-modal/auth-sign-edit-modal.component';
import { DepartAddModalComponent } from './department/components/depart-add-modal/depart-add-modal.component';
import { DepartEditModalComponent } from './department/components/depart-edit-modal/depart-edit-modal.component';
import { GrnAddModalComponent } from './grn/components/grn-add-modal/grn-add-modal.component';
import { GrnEditModalComponent } from './grn/components/grn-edit-modal/grn-edit-modal.component';
import { MajorHeadAddModalComponent } from './major-head/components/major-head-add-modal/major-head-add-modal.component';
import { MajorHeadEditModalComponent } from './major-head/components/major-head-edit-modal/major-head-edit-modal.component';
import { MinorHeadAddModalComponent } from './minor-head/components/minor-head-add-modal/minor-head-add-modal.component';
import { MinorHeadEditModalComponent } from './minor-head/components/minor-head-edit-modal/minor-head-edit-modal.component';
import { PermAddModalComponent } from './permission/components/perm-add-modal/perm-add-modal.component';
import { PermEditModalComponent } from './permission/components/perm-edit-modal/perm-edit-modal.component';
import { RoleAddModalComponent } from './role/components/role-add-modal/role-add-modal.component';
import { RoleEditModalComponent } from './role/components/role-edit-modal/role-edit-modal.component';
import { UniAddModalComponent } from './university/components/uni-add-modal/uni-add-modal.component';
import { UniEditModalComponent } from './university/components/uni-edit-modal/uni-edit-modal.component';
import { UserAddModalComponent } from './user/components/user-add-modal/user-add-modal.component';
import { UserEditModalComponent } from './user/components/user-edit-modal/user-edit-modal.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


@NgModule({
	declarations: [PermissionComponent,
		RoleComponent,
		UserComponent,
		DepartmentComponent,
		UniversityComponent,
		AuthorizeSignatoryComponent,
		AuthorizeLvlComponent,
		MajorHeadComponent,
		MinorHeadComponent,
		GrnComponent,
		AuthLvlAddModalComponent,
		AuthLvlEditModalComponent,
		AuthSignAddModalComponent,
		AuthSignEditModalComponent,
		DepartAddModalComponent,
		DepartEditModalComponent,
		GrnAddModalComponent,
		GrnEditModalComponent,
		MajorHeadAddModalComponent,
		MajorHeadEditModalComponent,
		MinorHeadAddModalComponent,
		MinorHeadEditModalComponent,
		PermAddModalComponent,
		PermEditModalComponent,
		RoleAddModalComponent,
		RoleEditModalComponent,
		UniAddModalComponent,
		UniEditModalComponent,
		UserAddModalComponent,
		UserEditModalComponent,
	],
  imports: [
		CommonModule,
		FormsModule,
		ReactiveFormsModule,
		PurchaseRoutingModule,
		NgZorroAntdModule
	],
	entryComponents: [
		AuthLvlAddModalComponent,
		AuthLvlEditModalComponent,		AuthSignAddModalComponent,
		AuthSignEditModalComponent,
		DepartAddModalComponent,
		DepartEditModalComponent,
		GrnAddModalComponent,
		GrnEditModalComponent,
		MajorHeadAddModalComponent,
		MajorHeadEditModalComponent,
		MinorHeadAddModalComponent,
		MinorHeadEditModalComponent,
		PermAddModalComponent,
		PermEditModalComponent,
		RoleAddModalComponent,
		RoleEditModalComponent,
		UniAddModalComponent,
		UniEditModalComponent,
		UserAddModalComponent,
		UserEditModalComponent
	]
})
export class PurchaseModule { }
