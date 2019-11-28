import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
	{
		path: 'admin',
		loadChildren: () => import('./modules/admin/admin.module').then(m => m.AdminModule)
	},
	{
		path: 'student',
		loadChildren: () => import('./modules/student/student.module').then(m => m.StudentModule)
	},
	{
		path: 'bank',
		loadChildren: () => import('./modules/bank/bank.module').then(m => m.BankModule)
	}


];

@NgModule({
	imports: [RouterModule.forRoot(routes)],
	exports: [RouterModule]
})
export class AppRoutingModule { }
