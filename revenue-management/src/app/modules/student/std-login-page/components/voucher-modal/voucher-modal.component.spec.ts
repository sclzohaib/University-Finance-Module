import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VoucherModalComponent } from './voucher-modal.component';

describe('VoucherModalComponent', () => {
  let component: VoucherModalComponent;
  let fixture: ComponentFixture<VoucherModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VoucherModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VoucherModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
