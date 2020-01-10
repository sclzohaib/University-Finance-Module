import { HomeComponent } from './home/home.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginPageComponent } from './login-page/login-page.component';
import { AuthGuard } from './Authentication/helpers/auth.guard';

const routes: Routes = [
	{
		path: 'home',
		canActivate: [AuthGuard],
		component: HomeComponent,
		pathMatch: 'full'
	},
	{
		path: '',
		component: LoginPageComponent,
		pathMatch: 'full'
	},
	{
		path: 'admin',
		canActivate: [AuthGuard],
		data: { roles: ['Admin'] },
		loadChildren: () => import('./modules/admin/admin.module').then(m => m.AdminModule)
	},
	{
		path: 'student',
		canActivate: [AuthGuard],
		data: { roles: ['Admin'] },
		loadChildren: () => import('./modules/student/student.module').then(m => m.StudentModule)
	},
	{
		path: 'bank',
		canActivate: [AuthGuard],
		data: { roles: ['Admin'] },
		loadChildren: () => import('./modules/bank/bank.module').then(m => m.BankModule)
	},
	{
		path: 'purchase',
		canActivate: [AuthGuard],
		data: { roles: ['Admin','Chairman'] },
		loadChildren: () => import('./modules/purchase/purchase.module').then(m => m.PurchaseModule)
	}


];

@NgModule({
	imports: [RouterModule.forRoot(routes)],
	exports: [RouterModule]
})
export class AppRoutingModule { }
