import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { StudentRoutingModule } from './student-routing.module';
import { FlexLayoutModule } from '@angular/flex-layout';
import { NgZorroAntdModule } from 'ng-zorro-antd';
import { StdLoginPageComponent } from './std-login-page/std-login-page.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { VoucherModalComponent } from './std-login-page/components/voucher-modal/voucher-modal.component';

@NgModule({
	declarations: [StdLoginPageComponent, VoucherModalComponent],
	imports: [
		CommonModule,
		StudentRoutingModule,
		FlexLayoutModule,
		NgZorroAntdModule,
		ReactiveFormsModule,
		FormsModule
	],
	entryComponents:[
		VoucherModalComponent
	]
})
export class StudentModule { }
