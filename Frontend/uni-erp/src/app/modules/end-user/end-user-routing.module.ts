import { ApplicationComponent } from './application/application.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DetailsPageComponent } from './application/components/details-page/details-page.component';


const routes: Routes = [
	{
		path: '',
		component: ApplicationComponent,
		pathMatch: "full"
	},
	{
		path: 'detail/:id',
		component: DetailsPageComponent,
	}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EndUserRoutingModule { }
