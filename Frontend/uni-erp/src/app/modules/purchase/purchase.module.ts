import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

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


@NgModule({
  declarations: [PermissionComponent, RoleComponent, UserComponent, DepartmentComponent, UniversityComponent, AuthorizeSignatoryComponent, AuthorizeLvlComponent, MajorHeadComponent, MinorHeadComponent, GrnComponent],
  imports: [
    CommonModule,
    PurchaseRoutingModule
  ]
})
export class PurchaseModule { }
