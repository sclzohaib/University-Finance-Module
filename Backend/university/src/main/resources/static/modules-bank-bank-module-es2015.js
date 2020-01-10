(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["modules-bank-bank-module"],{

/***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/modules/bank/bank-page/bank-page.component.html":
/*!*******************************************************************************************************!*\
  !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/modules/bank/bank-page/bank-page.component.html ***!
  \*******************************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("<div fxLayout fxLayoutGap=\"8px\">\r\n\t<div class=\"search\">\r\n\t\t<nz-input-group nzSearch nzSize=\"large\" [nzAddOnAfter]=\"searchButton\">\r\n\t\t\t<input type=\"text\" nz-input placeholder=\"Search with CNIC\" [(ngModel)]=\"criteria\" (ngModelChange)=\"criteriaChange($event)\" minlength=\"13\" maxlength=\"13\" pattern=\"[0-9]{13}\"/>\r\n\t\t</nz-input-group>\r\n\t\t<ng-template #searchButton>\r\n\t\t\t<button nz-button nzType=\"primary\" nzSize=\"large\" (click)=\"search()\" nzSearch><i nz-icon nzType=\"search\"></i></button>\r\n\t\t</ng-template>\r\n\t</div>\r\n</div>\r\n<nz-table nzBordered #revenueTable [nzData]=\"revenueData\">\r\n\t<thead>\r\n\t\t<tr>\r\n\t\t\t<th nzWidth=\"50px\">ID</th>\r\n\t\t\t<th>Student CNIC</th>\r\n\t\t\t<th>Revenue Head</th>\r\n\t\t\t<th>Student Type</th>\r\n\t\t\t<th nzWidth=\"100px\">Amount</th>\r\n\t\t\t<th nzWidth=\"80px\">Action</th>\r\n\t\t</tr>\r\n\t</thead>\r\n\t<tbody>\r\n\t\t<tr *ngFor=\"let data of revenueTable.data; let i = index\">\r\n\t\t\t<td>{{ i + 1 }}</td>\r\n\t\t\t<td>{{ data.studentCnic | cnicFormatter }}</td>\r\n\t\t\t<td>{{ data.revenueHead }}</td>\r\n\t\t\t<td>{{ data.studentType }}</td>\r\n\t\t\t<td>Rs. {{ data.amount }}</td>\r\n\t\t\t<td><div><button nz-button nzType=\"primary\" nzSize=\"large\" (click)=\"pay()\">Paid</button></div>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</tbody>\r\n</nz-table>");

/***/ }),

/***/ "./src/app/modules/bank/bank-page/bank-page.component.less":
/*!*****************************************************************!*\
  !*** ./src/app/modules/bank/bank-page/bank-page.component.less ***!
  \*****************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL21vZHVsZXMvYmFuay9iYW5rLXBhZ2UvYmFuay1wYWdlLmNvbXBvbmVudC5sZXNzIn0= */");

/***/ }),

/***/ "./src/app/modules/bank/bank-page/bank-page.component.ts":
/*!***************************************************************!*\
  !*** ./src/app/modules/bank/bank-page/bank-page.component.ts ***!
  \***************************************************************/
/*! exports provided: BankPageComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "BankPageComponent", function() { return BankPageComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
/* harmony import */ var src_app_core_services_revenue_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! src/app/core/services/revenue.service */ "./src/app/core/services/revenue.service.ts");



let BankPageComponent = class BankPageComponent {
    constructor(revSvc) {
        this.revSvc = revSvc;
        this.revenueData = [];
        this._revenueData = [];
        this.criteria = null;
        this.subscriptions = [];
    }
    ngOnInit() {
        this.subscriptions[0] = this.revSvc.data.subscribe(x => {
            this._revenueData = x;
            this.revenueData = this._revenueData;
        });
    }
    pay() {
        console.log("abc");
    }
    search() {
        if (this.criteria)
            this.revenueData = this._revenueData.filter(x => x.studentCnic === this.criteria);
        else
            this.revenueData = this._revenueData.map(x => x);
    }
    ngOnDestroy() {
        this.subscriptions.forEach(x => x.unsubscribe());
    }
};
BankPageComponent.ctorParameters = () => [
    { type: src_app_core_services_revenue_service__WEBPACK_IMPORTED_MODULE_2__["RevenueService"] }
];
BankPageComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
        selector: 'app-bank-page',
        template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! raw-loader!./bank-page.component.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/modules/bank/bank-page/bank-page.component.html")).default,
        styles: [tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! ./bank-page.component.less */ "./src/app/modules/bank/bank-page/bank-page.component.less")).default]
    })
], BankPageComponent);



/***/ }),

/***/ "./src/app/modules/bank/bank-routing.module.ts":
/*!*****************************************************!*\
  !*** ./src/app/modules/bank/bank-routing.module.ts ***!
  \*****************************************************/
/*! exports provided: BankRoutingModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "BankRoutingModule", function() { return BankRoutingModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm2015/router.js");
/* harmony import */ var _bank_page_bank_page_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./bank-page/bank-page.component */ "./src/app/modules/bank/bank-page/bank-page.component.ts");




const routes = [
    { path: '',
        component: _bank_page_bank_page_component__WEBPACK_IMPORTED_MODULE_3__["BankPageComponent"],
        pathMatch: 'full'
    }
];
let BankRoutingModule = class BankRoutingModule {
};
BankRoutingModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
        imports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"].forChild(routes)],
        exports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"]]
    })
], BankRoutingModule);



/***/ }),

/***/ "./src/app/modules/bank/bank.module.ts":
/*!*********************************************!*\
  !*** ./src/app/modules/bank/bank.module.ts ***!
  \*********************************************/
/*! exports provided: BankModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "BankModule", function() { return BankModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/fesm2015/common.js");
/* harmony import */ var _bank_routing_module__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./bank-routing.module */ "./src/app/modules/bank/bank-routing.module.ts");
/* harmony import */ var _bank_page_bank_page_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./bank-page/bank-page.component */ "./src/app/modules/bank/bank-page/bank-page.component.ts");
/* harmony import */ var ng_zorro_antd__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ng-zorro-antd */ "./node_modules/ng-zorro-antd/fesm2015/ng-zorro-antd.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm2015/forms.js");
/* harmony import */ var _angular_flex_layout__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/flex-layout */ "./node_modules/@angular/flex-layout/esm2015/flex-layout.js");
/* harmony import */ var src_app_core_pipes_cnic_formatter_pipe__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! src/app/core/pipes/cnic-formatter.pipe */ "./src/app/core/pipes/cnic-formatter.pipe.ts");









let BankModule = class BankModule {
};
BankModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
        declarations: [_bank_page_bank_page_component__WEBPACK_IMPORTED_MODULE_4__["BankPageComponent"], src_app_core_pipes_cnic_formatter_pipe__WEBPACK_IMPORTED_MODULE_8__["CnicFormatterPipe"]],
        imports: [
            _angular_common__WEBPACK_IMPORTED_MODULE_2__["CommonModule"],
            _bank_routing_module__WEBPACK_IMPORTED_MODULE_3__["BankRoutingModule"],
            ng_zorro_antd__WEBPACK_IMPORTED_MODULE_5__["NgZorroAntdModule"],
            _angular_forms__WEBPACK_IMPORTED_MODULE_6__["FormsModule"],
            _angular_flex_layout__WEBPACK_IMPORTED_MODULE_7__["FlexLayoutModule"],
        ]
    })
], BankModule);



/***/ })

}]);
//# sourceMappingURL=modules-bank-bank-module-es2015.js.map