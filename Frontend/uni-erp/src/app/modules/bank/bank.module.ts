import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BankRoutingModule } from './bank-routing.module';
import { BankPageComponent } from './bank-page/bank-page.component';
import { NgZorroAntdModule } from 'ng-zorro-antd';
import { FormsModule } from '@angular/forms';
import { FlexLayoutModule } from '@angular/flex-layout';
import { CnicFormatterPipe } from 'src/app/core/pipes/cnic-formatter.pipe';


@NgModule({
  declarations: [BankPageComponent,CnicFormatterPipe],
  imports: [
    CommonModule,
    BankRoutingModule,
		NgZorroAntdModule,
		FormsModule,
		FlexLayoutModule,

  ]
})
export class BankModule { }
