import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GrnAddModalComponent } from './grn-add-modal.component';

describe('GrnAddModalComponent', () => {
  let component: GrnAddModalComponent;
  let fixture: ComponentFixture<GrnAddModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GrnAddModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GrnAddModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
