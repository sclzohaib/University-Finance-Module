import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ControlRoutingModule } from './control-routing.module';
import { DepartmentPageComponent } from './department-page/department-page.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { NgZorroAntdModule } from 'ng-zorro-antd';
import { FlexLayoutModule } from '@angular/flex-layout';
import { FeePageComponent } from './fee-page/fee-page.component';
import { RevenueHeadComponent } from './revenue-head/revenue-head.component';
import { StudentTypeComponent } from './student-type/student-type.component';
import { ClassPageComponent } from './class-page/class-page.component';
import { PartPageComponent } from './part-page/part-page.component';
import { AddmodalComponent } from './department-page/components/addmodal/addmodal.component';
import { EditmodalComponent } from './department-page/components/editmodal/editmodal.component';
import { StdAddmodalComponent } from './student-type/components/std-addmodal/std-addmodal.component';
import { StdEditmodalComponent } from './student-type/components/std-editmodal/std-editmodal.component';
import { RhAddmodalComponent } from './revenue-head/components/rh-addmodal/rh-addmodal.component';
import { RhEditmodalComponent } from './revenue-head/components/rh-editmodal/rh-editmodal.component';
import { ClAddmodalComponent } from './class-page/components/cl-addmodal/cl-addmodal.component';
import { ClEditmodalComponent } from './class-page/components/cl-editmodal/cl-editmodal.component';
import { PtAddmodalComponent } from './part-page/components/pt-addmodal/pt-addmodal.component';
import { PtEditmodalComponent } from './part-page/components/pt-editmodal/pt-editmodal.component';
import { CommaSpacerPipe } from 'src/app/core/pipes/comma-spacer.pipe';
import { FtaddmodalComponent } from './fee-page/components/ftaddmodal/ftaddmodal.component';
import { FteditmodalComponent } from './fee-page/components/fteditmodal/fteditmodal.component';

@NgModule({
	declarations: [
		DepartmentPageComponent,
		FeePageComponent,
		RevenueHeadComponent,
		StudentTypeComponent,
		ClassPageComponent,
		PartPageComponent,
		AddmodalComponent,
		EditmodalComponent,
		StdAddmodalComponent,
		StdEditmodalComponent,
		RhAddmodalComponent,
		RhEditmodalComponent,
		ClAddmodalComponent,
		ClEditmodalComponent,
		PtAddmodalComponent,
		PtEditmodalComponent,
		CommaSpacerPipe,
		FtaddmodalComponent,
		FteditmodalComponent
	],
	imports: [
		CommonModule,
		FormsModule,
		ControlRoutingModule,
		ReactiveFormsModule,
		NgZorroAntdModule,
		FlexLayoutModule,
	],
	entryComponents: [
		EditmodalComponent,
		StdEditmodalComponent,
		RhEditmodalComponent,
		ClEditmodalComponent,
		PtEditmodalComponent,
		ClAddmodalComponent,
		StdAddmodalComponent,
		PtAddmodalComponent,
		AddmodalComponent,
		RhAddmodalComponent,
		FtaddmodalComponent,
		FteditmodalComponent
	]
})
export class ControlModule { }
