import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { QuotationAddModalComponent } from './quotation-add-modal.component';

describe('QuotationAddModalComponent', () => {
  let component: QuotationAddModalComponent;
  let fixture: ComponentFixture<QuotationAddModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ QuotationAddModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(QuotationAddModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
