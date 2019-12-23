import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MinorHeadAddModalComponent } from './minor-head-add-modal.component';

describe('MinorHeadAddModalComponent', () => {
  let component: MinorHeadAddModalComponent;
  let fixture: ComponentFixture<MinorHeadAddModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MinorHeadAddModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MinorHeadAddModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
