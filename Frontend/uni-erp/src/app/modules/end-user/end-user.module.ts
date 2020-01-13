import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EndUserRoutingModule } from './end-user-routing.module';
import { ApplicationComponent } from './application/application.component';
import { ApplicationAddModalComponent } from './application/components/application-add-modal/application-add-modal.component';
import { ApplicationViewModalComponent } from './application/components/application-view-modal/application-view-modal.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgZorroAntdModule } from 'ng-zorro-antd';
import { FlexLayoutModule } from '@angular/flex-layout';


@NgModule({
  declarations: [ApplicationComponent, ApplicationAddModalComponent, ApplicationViewModalComponent],
  imports: [
    CommonModule,
		EndUserRoutingModule,
		FormsModule,
		ReactiveFormsModule,
		NgZorroAntdModule,
		FlexLayoutModule
	],
	entryComponents: [
		ApplicationAddModalComponent, ApplicationViewModalComponent
	]
})
export class EndUserModule { }
