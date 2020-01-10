(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["revenue-revenue-module"],{

/***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/modules/admin/revenue/dues-page/dues-page.component.html":
/*!****************************************************************************************************************!*\
  !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/modules/admin/revenue/dues-page/dues-page.component.html ***!
  \****************************************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("<button nz-button nzType=\"primary\" (click)=\"showModal()\">\r\n\t<span>Fee Waive</span>\r\n</button>\r\n<nz-modal [(nzVisible)]=\"isVisible\" nzTitle=\"Fee Waive Details\" (nzOnCancel)=\"handleCancel()\" (nzOnOk)=\"handleOk()\" [nzOkLoading]=\"isOkLoading\">\r\n\t<form nz-form>\r\n\t\t<nz-form-item>\r\n\t\t\t<nz-form-label [nzSm]=\"6\">CNIC</nz-form-label>\r\n\t\t\t<nz-form-control [nzSm]=\"16\">\r\n\t\t\t\t<input placeholder=\"Enter student's CNIC number\" nz-input />\r\n\t\t\t</nz-form-control>\r\n\t\t</nz-form-item>\r\n\t\t<nz-form-item>\r\n\t\t\t<nz-form-label [nzSm]=\"6\">Seat No. </nz-form-label>\r\n\t\t\t<nz-form-control [nzSm]=\"16\">\r\n\t\t\t\t<input placeholder=\"Enter student's seat number\" nz-input />\r\n\t\t\t</nz-form-control>\r\n\t\t</nz-form-item>\r\n\r\n\t\t<nz-row [nzGutter]=3>\r\n\t\t\t<nz-col nzSpan=3><label><strong> Waive By</strong> </label></nz-col>\r\n\t\t\t<nz-col nzSpan=\"15\">\r\n\t\t\t\t<nz-slider [nzMarks]=\"marks\" [(ngModel)]=\"value\" [ngModelOptions]=\"{standalone: true}\" (ngModelChange)=sliderMove()></nz-slider>\r\n\t\t\t</nz-col>\r\n\t\t\t<div nz-col nzSpan=\"2\">\r\n\t\t\t\t<nz-input-number [ngStyle]=\"{ marginLeft: '16px' }\" [(ngModel)]=\"waiveAmount\" [ngModelOptions]=\"{standalone: true}\" (ngModelChange)=\"inputValueChange()\"></nz-input-number>\r\n\t\t\t</div>\r\n\r\n\t\t</nz-row>\r\n\t\t<br>\r\n\t\t<nz-row [nzGutter]=\"16\">\r\n\t\t\t<nz-col [nzSpan]=\"12\">\r\n\t\t\t\t<nz-statistic [nzValue]=\"actualFee\" [nzSuffix]=\"'RS'\" [nzTitle]=\"'Actual Fee'\"></nz-statistic>\r\n\t\t\t</nz-col>\r\n\t\t\t<nz-col [nzSpan]=\"12\">\r\n\t\t\t\t<nz-statistic [nzValue]=\"actualFee-waiveAmount\" [nzSuffix]=\"'RS'\" [nzTitle]=\"'After Waive'\"></nz-statistic>\r\n\t\t\t</nz-col>\r\n\t\t</nz-row>\r\n\t</form>\r\n</nz-modal>\r\n<nz-table #basicTable [nzData]=\"listOfData\">\r\n\t<thead>\r\n\t\t<tr>\r\n\t\t\t<th nzwidth=\"30%\">Student CNIC</th>\r\n\t\t\t<th nzwidth=\"30%\">Particular Name</th>\r\n\t\t\t<th>Fee Amount</th>\r\n\t\t</tr>\r\n\t</thead>\r\n\t<tbody>\r\n\t\t<tr *ngFor=\"let data of basicTable.data\">\r\n\t\t\t<td>{{ data.CNIC }}</td>\r\n\t\t\t<td>{{ data.parName }}</td>\r\n\t\t\t<td>{{data.Amount}}</td>\r\n\t\t</tr>\r\n\t</tbody>\r\n</nz-table>");

/***/ }),

/***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/modules/admin/revenue/revenue-page/revenue-page.component.html":
/*!**********************************************************************************************************************!*\
  !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/modules/admin/revenue/revenue-page/revenue-page.component.html ***!
  \**********************************************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("<div fxLayout fxLayoutGap=\"8px\">\r\n\t<div class=\"search\">\r\n\t\t<nz-input-group nzSearch nzSize=\"large\" [nzAddOnAfter]=\"searchButton\">\r\n\t\t\t<input type=\"text\" nz-input placeholder=\"Search with CNIC\" [(ngModel)]=\"criteria\" minlength=\"13\" maxlength=\"13\" pattern=\"[0-9]{13}\"/>\r\n\t\t</nz-input-group>\r\n\t\t<ng-template #searchButton>\r\n\t\t\t<button nz-button nzType=\"primary\" nzSize=\"large\" (click)=\"search()\" nzSearch><i nz-icon nzType=\"search\"></i></button>\r\n\t\t</ng-template>\r\n\t</div>\r\n\t<div>\r\n\t\t<nz-select nzPlaceHolder=\"Show By\" style=\"width: 120px;\" [(ngModel)]=\"showByType\" nzSize=\"large\">\r\n\t\t\t<nz-option *ngFor=\"let s of showByData; let i = index\" [nzValue]=\"i\" [nzLabel]=\"s.name\"></nz-option>\r\n\t\t</nz-select>\r\n\t</div>\r\n\t<div *ngIf=\"showByType === 0\">\r\n\t\t<nz-month-picker nzSize=\"large\" nzFormat=\"MMM yyyy\" [(ngModel)]=\"selectedDate\" (ngModelChange)=\"monthChange($event)\" nzPlaceHolder=\"Select Month\"></nz-month-picker>\r\n\t</div>\r\n\t<div *ngIf=\"showByType && showByType !== 0\">\r\n\t\t<nz-select style=\"width: 200px;\" [nzPlaceHolder]=\"showByData[showByType].placeholder\" [(ngModel)]=\"selection\" (ngModelChange)=\"selectionChange($event)\" nzSize=\"large\">\r\n\t\t\t<nz-option *ngFor=\"let s of selectionData[showByData[showByType].name]\" [nzValue]=\"s\" [nzLabel]=\"s\"></nz-option>\r\n\t\t</nz-select>\r\n\t</div>\r\n\t<div class=\"clear\">\r\n\t\t<button nz-button (click)=\"clearFilters()\" nzSize=\"large\" nzType=\"primary\" [disabled]=\"showByType === null\">Clear Filters</button>\r\n\t</div>\r\n</div>\r\n<nz-table nzBordered #revenueTable [nzData]=\"revenueData\">\r\n\t<thead>\r\n\t\t<tr>\r\n\t\t\t<th nzWidth=\"50px\">ID</th>\r\n\t\t\t<th>Student CNIC</th>\r\n\t\t\t<th>Revenue Head</th>\r\n\t\t\t<th>Student Type</th>\r\n\t\t\t<th nzWidth=\"100px\">Amount</th>\r\n\t\t</tr>\r\n\t</thead>\r\n\t<tbody>\r\n\t\t<tr *ngFor=\"let data of revenueTable.data; let i = index\">\r\n\t\t\t<td>{{ i + 1 }}</td>\r\n\t\t\t<td>{{ data.studentCnic | cnicFormatter }}</td>\r\n\t\t\t<td>{{ data.revenueHead }}</td>\r\n\t\t\t<td>{{ data.studentType }}</td>\r\n\t\t\t<td>Rs. {{ data.amount }}</td>\r\n\t\t</tr>\r\n\t</tbody>\r\n</nz-table>");

/***/ }),

/***/ "./src/app/modules/admin/revenue/dues-page/dues-page.component.less":
/*!**************************************************************************!*\
  !*** ./src/app/modules/admin/revenue/dues-page/dues-page.component.less ***!
  \**************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL21vZHVsZXMvYWRtaW4vcmV2ZW51ZS9kdWVzLXBhZ2UvZHVlcy1wYWdlLmNvbXBvbmVudC5sZXNzIn0= */");

/***/ }),

/***/ "./src/app/modules/admin/revenue/dues-page/dues-page.component.ts":
/*!************************************************************************!*\
  !*** ./src/app/modules/admin/revenue/dues-page/dues-page.component.ts ***!
  \************************************************************************/
/*! exports provided: DuesPageComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "DuesPageComponent", function() { return DuesPageComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");


let DuesPageComponent = class DuesPageComponent {
    constructor() {
        this.isVisible = false;
        this.isOkLoading = false;
        this.value = 1;
        this.actualFee = 1000;
        this.waiveAmount = this.actualFee * (this.value / 100);
        this.finalFee = this.actualFee - this.waiveAmount;
        this.marks = {
            0: '0%',
            25: '25%',
            50: '50%',
            75: '75%',
            100: {
                style: {
                    color: '#66b3ff'
                },
                label: '<strong>100%</strong>'
            }
        };
        this.listOfData = [
            {
                CNIC: '42201-7899029-7',
                parName: 'particular',
                Amount: '0'
            },
        ];
    }
    sliderMove() {
        this.waiveAmount = this.actualFee * (this.value / 100);
    }
    inputValueChange() {
        this.value = (this.waiveAmount * 100) / this.actualFee;
    }
    ngOnInit() {
    }
    showModal() {
        this.isVisible = true;
    }
    handleOk() {
        this.isOkLoading = true;
        setTimeout(() => {
            this.isVisible = false;
            this.isOkLoading = false;
        }, 1500);
    }
    handleCancel() {
        this.isVisible = false;
    }
};
DuesPageComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
        selector: 'app-dues-page',
        template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! raw-loader!./dues-page.component.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/modules/admin/revenue/dues-page/dues-page.component.html")).default,
        styles: [tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! ./dues-page.component.less */ "./src/app/modules/admin/revenue/dues-page/dues-page.component.less")).default]
    })
], DuesPageComponent);



/***/ }),

/***/ "./src/app/modules/admin/revenue/revenue-page/revenue-page.component.less":
/*!********************************************************************************!*\
  !*** ./src/app/modules/admin/revenue/revenue-page/revenue-page.component.less ***!
  \********************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = (".clear {\n  margin-left: auto;\n}\nnz-table {\n  margin-top: 16px;\n}\n\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvbW9kdWxlcy9hZG1pbi9yZXZlbnVlL3JldmVudWUtcGFnZS9EOi9Qcm9qZWN0cy9Vbml2ZXJzaXR5IEZpbmFuY2UgTW9kdWxlL1Byb2plY3QvVW5pdmVyc2l0eS1GaW5hbmNlLU1vZHVsZS9Gcm9udGVuZC91bmktZXJwL3NyYy9hcHAvbW9kdWxlcy9hZG1pbi9yZXZlbnVlL3JldmVudWUtcGFnZS9yZXZlbnVlLXBhZ2UuY29tcG9uZW50Lmxlc3MiLCJzcmMvYXBwL21vZHVsZXMvYWRtaW4vcmV2ZW51ZS9yZXZlbnVlLXBhZ2UvcmV2ZW51ZS1wYWdlLmNvbXBvbmVudC5sZXNzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0VBQ0MsaUJBQUE7QUNDRDtBREVBO0VBQ0MsZ0JBQUE7QUNBRCIsImZpbGUiOiJzcmMvYXBwL21vZHVsZXMvYWRtaW4vcmV2ZW51ZS9yZXZlbnVlLXBhZ2UvcmV2ZW51ZS1wYWdlLmNvbXBvbmVudC5sZXNzIiwic291cmNlc0NvbnRlbnQiOlsiLmNsZWFyIHtcblx0bWFyZ2luLWxlZnQ6IGF1dG87XG59XG5cbm56LXRhYmxlIHtcblx0bWFyZ2luLXRvcDogMTZweDtcbn0iLCIuY2xlYXIge1xuICBtYXJnaW4tbGVmdDogYXV0bztcbn1cbm56LXRhYmxlIHtcbiAgbWFyZ2luLXRvcDogMTZweDtcbn1cbiJdfQ== */");

/***/ }),

/***/ "./src/app/modules/admin/revenue/revenue-page/revenue-page.component.ts":
/*!******************************************************************************!*\
  !*** ./src/app/modules/admin/revenue/revenue-page/revenue-page.component.ts ***!
  \******************************************************************************/
/*! exports provided: RevenuePageComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "RevenuePageComponent", function() { return RevenuePageComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
/* harmony import */ var src_app_core_services_revenue_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! src/app/core/services/revenue.service */ "./src/app/core/services/revenue.service.ts");
/* harmony import */ var src_app_core_services_revenuehead_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! src/app/core/services/revenuehead.service */ "./src/app/core/services/revenuehead.service.ts");
/* harmony import */ var src_app_core_services_department_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! src/app/core/services/department.service */ "./src/app/core/services/department.service.ts");
/* harmony import */ var src_app_core_services_studenttype_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/app/core/services/studenttype.service */ "./src/app/core/services/studenttype.service.ts");






let RevenuePageComponent = class RevenuePageComponent {
    constructor(revSvc, rhSvc, deptSvc, stTypeSvc) {
        this.revSvc = revSvc;
        this.rhSvc = rhSvc;
        this.deptSvc = deptSvc;
        this.stTypeSvc = stTypeSvc;
        this.revenueData = [];
        this._revenueData = [];
        this.selectedDate = null;
        this.criteria = null;
        this.showByType = null;
        this.selection = null;
        this.showByData = [
            {
                name: 'Month',
                placeholder: 'Select Month'
            },
            {
                name: 'Department',
                placeholder: 'Select Department'
            },
            {
                name: 'Head',
                placeholder: 'Select Revenue Head'
            },
            {
                name: 'Student Type',
                placeholder: 'Select Student Type'
            },
            {
                name: 'Shift',
                placeholder: 'Select Shift'
            }
        ];
        this.selectionData = {
            Month: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
                'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'
            ],
            Department: [],
            Head: [],
            'Student Type': [],
            Shift: ['Morning', 'Evening']
        };
        this.subscriptions = [];
    }
    ngOnInit() {
        this.subscriptions[0] = this.deptSvc.data.subscribe(x => this.selectionData['Department'] = x.map(y => y.name));
        this.subscriptions[1] = this.rhSvc.data.subscribe(x => this.selectionData['Head'] = x.map(y => y.name + ` (${y.code})`));
        this.subscriptions[2] = this.stTypeSvc.data.subscribe(x => this.selectionData['Student Type'] = x.map(y => y.name));
        this.subscriptions[3] = this.revSvc.data.subscribe(x => {
            this._revenueData = x;
            this.revenueData = this._revenueData;
        });
    }
    clearFilters() {
        this.showByType = null;
        this.selection = null;
        this.selectionChange(null);
    }
    monthChange(value) {
        this.revenueData = this._revenueData.filter(x => {
            if (value) {
                value.setDate(1);
                return new Date(x.monthYearPaid).toDateString() === value.toDateString();
            }
            else
                return true;
        });
    }
    selectionChange(value) {
        this.revenueData = this._revenueData.filter(x => {
            switch (this.showByType) {
                case 1: {
                    return value === x.department;
                }
                case 2: {
                    return value === x.revenueHead;
                }
                case 3: {
                    return value === x.studentType;
                }
                case 4: {
                    return value === x.shift;
                }
                default: {
                    return true;
                }
            }
        });
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
RevenuePageComponent.ctorParameters = () => [
    { type: src_app_core_services_revenue_service__WEBPACK_IMPORTED_MODULE_2__["RevenueService"] },
    { type: src_app_core_services_revenuehead_service__WEBPACK_IMPORTED_MODULE_3__["RevenueheadService"] },
    { type: src_app_core_services_department_service__WEBPACK_IMPORTED_MODULE_4__["DepartmentService"] },
    { type: src_app_core_services_studenttype_service__WEBPACK_IMPORTED_MODULE_5__["StudenttypeService"] }
];
RevenuePageComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
        selector: 'app-revenue-page',
        template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! raw-loader!./revenue-page.component.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/modules/admin/revenue/revenue-page/revenue-page.component.html")).default,
        styles: [tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! ./revenue-page.component.less */ "./src/app/modules/admin/revenue/revenue-page/revenue-page.component.less")).default]
    })
], RevenuePageComponent);



/***/ }),

/***/ "./src/app/modules/admin/revenue/revenue-routing.module.ts":
/*!*****************************************************************!*\
  !*** ./src/app/modules/admin/revenue/revenue-routing.module.ts ***!
  \*****************************************************************/
/*! exports provided: RevenueRoutingModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "RevenueRoutingModule", function() { return RevenueRoutingModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm2015/router.js");
/* harmony import */ var _revenue_page_revenue_page_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./revenue-page/revenue-page.component */ "./src/app/modules/admin/revenue/revenue-page/revenue-page.component.ts");
/* harmony import */ var _dues_page_dues_page_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./dues-page/dues-page.component */ "./src/app/modules/admin/revenue/dues-page/dues-page.component.ts");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm2015/forms.js");






const routes = [
    {
        path: 'revenue-page',
        component: _revenue_page_revenue_page_component__WEBPACK_IMPORTED_MODULE_3__["RevenuePageComponent"],
        pathMatch: 'full'
    },
    {
        path: 'due-page',
        component: _dues_page_dues_page_component__WEBPACK_IMPORTED_MODULE_4__["DuesPageComponent"],
        pathMatch: 'full'
    }
];
let RevenueRoutingModule = class RevenueRoutingModule {
};
RevenueRoutingModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
        imports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"].forChild(routes),
            _angular_forms__WEBPACK_IMPORTED_MODULE_5__["FormsModule"]
        ],
        exports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"]]
    })
], RevenueRoutingModule);



/***/ }),

/***/ "./src/app/modules/admin/revenue/revenue.module.ts":
/*!*********************************************************!*\
  !*** ./src/app/modules/admin/revenue/revenue.module.ts ***!
  \*********************************************************/
/*! exports provided: RevenueModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "RevenueModule", function() { return RevenueModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/fesm2015/common.js");
/* harmony import */ var _revenue_routing_module__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./revenue-routing.module */ "./src/app/modules/admin/revenue/revenue-routing.module.ts");
/* harmony import */ var _revenue_page_revenue_page_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./revenue-page/revenue-page.component */ "./src/app/modules/admin/revenue/revenue-page/revenue-page.component.ts");
/* harmony import */ var _dues_page_dues_page_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./dues-page/dues-page.component */ "./src/app/modules/admin/revenue/dues-page/dues-page.component.ts");
/* harmony import */ var ng_zorro_antd__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ng-zorro-antd */ "./node_modules/ng-zorro-antd/fesm2015/ng-zorro-antd.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm2015/forms.js");
/* harmony import */ var _angular_flex_layout__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @angular/flex-layout */ "./node_modules/@angular/flex-layout/esm2015/flex-layout.js");
/* harmony import */ var src_app_core_pipes_cnic_formatter_pipe__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! src/app/core/pipes/cnic-formatter.pipe */ "./src/app/core/pipes/cnic-formatter.pipe.ts");










let RevenueModule = class RevenueModule {
};
RevenueModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
        declarations: [_revenue_page_revenue_page_component__WEBPACK_IMPORTED_MODULE_4__["RevenuePageComponent"], _dues_page_dues_page_component__WEBPACK_IMPORTED_MODULE_5__["DuesPageComponent"], src_app_core_pipes_cnic_formatter_pipe__WEBPACK_IMPORTED_MODULE_9__["CnicFormatterPipe"]],
        imports: [
            _angular_common__WEBPACK_IMPORTED_MODULE_2__["CommonModule"],
            ng_zorro_antd__WEBPACK_IMPORTED_MODULE_6__["NgZorroAntdModule"],
            _revenue_routing_module__WEBPACK_IMPORTED_MODULE_3__["RevenueRoutingModule"],
            _angular_forms__WEBPACK_IMPORTED_MODULE_7__["FormsModule"],
            _angular_flex_layout__WEBPACK_IMPORTED_MODULE_8__["FlexLayoutModule"],
        ]
    })
], RevenueModule);



/***/ })

}]);
//# sourceMappingURL=revenue-revenue-module-es2015.js.map