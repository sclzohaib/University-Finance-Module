import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BankPageComponent } from './bank-page/bank-page.component';


const routes: Routes = [ 
   {path: '',
component: BankPageComponent,
pathMatch: 'full'
}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BankRoutingModule { }
