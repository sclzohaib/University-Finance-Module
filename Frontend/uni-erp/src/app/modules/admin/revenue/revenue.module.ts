import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RevenueRoutingModule } from './revenue-routing.module';
import { RevenuePageComponent } from './revenue-page/revenue-page.component';
import { DuesPageComponent } from './dues-page/dues-page.component';
import { NgZorroAntdModule } from 'ng-zorro-antd';
import { FormsModule } from '@angular/forms';
import { FlexLayoutModule } from '@angular/flex-layout';
import { CnicFormatterPipe } from 'src/app/core/pipes/cnic-formatter.pipe';

@NgModule({
	declarations: [RevenuePageComponent, DuesPageComponent, CnicFormatterPipe],
	imports: [
		CommonModule,
		NgZorroAntdModule,
		RevenueRoutingModule,
		FormsModule,
		FlexLayoutModule,
	]
})
export class RevenueModule { }
