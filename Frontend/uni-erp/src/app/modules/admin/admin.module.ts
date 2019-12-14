import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin-routing.module';
import { LoginPageComponent } from './login-page/login-page.component';
import { NgZorroAntdModule } from 'ng-zorro-antd';
import { ReactiveFormsModule } from '@angular/forms';
import { FlexLayoutModule } from '@angular/flex-layout';


@NgModule({
	declarations: [LoginPageComponent],
	imports: [
		CommonModule,
		NgZorroAntdModule,
		AdminRoutingModule,
		ReactiveFormsModule,
		FlexLayoutModule
	]
})
export class AdminModule { }
