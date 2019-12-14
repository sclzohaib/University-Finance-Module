import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { StdLoginPageComponent } from './std-login-page/std-login-page.component';


const routes: Routes = [
	{
		path: '',
		component: StdLoginPageComponent,
		pathMatch: 'full'
	}
	
];

@NgModule({
	imports: [RouterModule.forChild(routes)],
	exports: [RouterModule]
})
export class StudentRoutingModule { }
