import { ClassPageComponent } from './class-page/class-page.component';
import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DepartmentPageComponent } from './department-page/department-page.component';
import { FeePageComponent } from './fee-page/fee-page.component';
import { StudentTypeComponent } from './student-type/student-type.component';
import { RevenueHeadComponent } from './revenue-head/revenue-head.component';
import { PartPageComponent } from './part-page/part-page.component';


const routes: Routes = [
	{
		path: 'department',
		component: DepartmentPageComponent,
		pathMatch: "full"
	},
	{
		path: 'fee',
		component: FeePageComponent,
		pathMatch: "full"
	},
	{
		path: 'revenue-head',
		component: RevenueHeadComponent,
		pathMatch: "full"
	},
	{
		path: 'student-type',
		component: StudentTypeComponent,
		pathMatch: "full"
	},
	{
		path: 'class',
		component: ClassPageComponent,
		pathMatch: "full"
	},
	{
		path: 'part',
		component: PartPageComponent,
		pathMatch: "full"
	},

];

@NgModule({
	imports: [RouterModule.forChild(routes),
	],
	exports: [RouterModule]
})
export class ControlRoutingModule { }
