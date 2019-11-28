import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RevenuePageComponent } from './revenue-page/revenue-page.component';
import { DuesPageComponent } from './dues-page/dues-page.component';
import { FormsModule } from '@angular/forms';


const routes: Routes = [
	{
		path: 'revenue-page',
		component: RevenuePageComponent,
		pathMatch: 'full'
	},
	{
		path: 'due-page',
		component: DuesPageComponent,
		pathMatch: 'full'
	}

];

@NgModule({
	imports: [RouterModule.forChild(routes),
		FormsModule
	],
	exports: [RouterModule]
})
export class RevenueRoutingModule { }
