
import { HomeComponent } from './home/home.component';
import { registerLocaleData } from '@angular/common';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import en from '@angular/common/locales/en';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { en_US, NgZorroAntdModule, NZ_I18N } from 'ng-zorro-antd';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { IconsProviderModule } from './icons-provider.module';
import { FlexLayoutModule } from "@angular/flex-layout";
import { PurchaseModule } from './modules/purchase/purchase.module';
import { BillModule } from './modules/bill/bill.module';
import { LoginPageComponent } from './login-page/login-page.component';
import { JwtInterceptor } from './Authentication/helpers/jwt.interceptor';
import { ErrorInterceptor } from './Authentication/helpers/error.interceptor';
import { EndUserModule } from './modules/end-user/end-user.module';

registerLocaleData(en);

@NgModule({
	declarations: [
		HomeComponent,
		LoginPageComponent,
		AppComponent
	],
	imports: [
		BrowserModule,
		AppRoutingModule,
		IconsProviderModule,
		NgZorroAntdModule,
		FormsModule,
		ReactiveFormsModule,
		HttpClientModule,
		BrowserAnimationsModule,
		FlexLayoutModule,
		PurchaseModule,
		BillModule,
		EndUserModule,
	],
	providers: [{ provide: NZ_I18N, useValue: en_US },
		{ provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
		{ provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true }
	],
	bootstrap: [AppComponent]
})
export class AppModule { }
