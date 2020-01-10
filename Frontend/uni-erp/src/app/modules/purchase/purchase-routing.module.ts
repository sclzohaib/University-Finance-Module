import { UserTypeComponent } from './user-type/user-type.component';
import { GstComponent } from './gst/gst.component';
import { UserComponent } from './user/user.component';
import { UniversityComponent } from './university/university.component';
import { RoleComponent } from './role/role.component';
import { PermissionComponent } from './permission/permission.component';
import { MinorHeadComponent } from './minor-head/minor-head.component';
import { MajorHeadComponent } from './major-head/major-head.component';
import { GrnComponent } from './grn/grn.component';
import { DepartmentComponent } from './department/department.component';
import { AuthorizeSignatoryComponent } from './authorize-signatory/authorize-signatory.component';
import { AuthorizeLvlComponent } from './authorize-lvl/authorize-lvl.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [
	{
		path: 'authorize-lvl',
		component: AuthorizeLvlComponent,
		pathMatch: 'full'
	},
	{
		path: 'authorize-signatory',
		component: AuthorizeSignatoryComponent,
		pathMatch: 'full'
	},
	{
		path: 'department',
		component: DepartmentComponent,
		pathMatch: 'full'
	},
	{
		path: 'grn',
		component: GrnComponent,
		pathMatch: 'full'
	},
	{
		path: 'major-head',
		component: MajorHeadComponent,
		pathMatch: 'full'
	},
	{
		path: 'minor-head',
		component: MinorHeadComponent,
		pathMatch: 'full'
	},
	{
		path: 'permission',
		component: PermissionComponent,
		pathMatch: 'full'
	},
	{
		path: 'role',
		component: RoleComponent,
		pathMatch: 'full'
	},
	{
		path: 'university',
		component: UniversityComponent,
		pathMatch: 'full'
	},
	{
		path: 'user',
		component: UserComponent,
		pathMatch: 'full'
	},
	{
		path: 'gst',
		component: GstComponent,
		pathMatch: 'full'
	},
	{
		path: 'user-type',
		component: UserTypeComponent,
		pathMatch: 'full'
	}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PurchaseRoutingModule { }
