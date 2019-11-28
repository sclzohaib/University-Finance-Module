import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginPageComponent } from './login-page/login-page.component';


const routes: Routes = [

	{
		path: 'revenue',
		loadChildren: () => import('./revenue/revenue.module').then(m => m.RevenueModule)
	},
	{
		path: 'control',
		loadChildren: () => import('./control/control.module').then(m => m.ControlModule)
	},
	{
		path: '',
		component: LoginPageComponent,
		pathMatch: 'full'

	}

];

@NgModule({
	imports: [RouterModule.forChild(routes)],
	exports: [RouterModule]
})
export class AdminRoutingModule { }
