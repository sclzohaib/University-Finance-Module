import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FteditmodalComponent } from './fteditmodal.component';

describe('FteditmodalComponent', () => {
  let component: FteditmodalComponent;
  let fixture: ComponentFixture<FteditmodalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FteditmodalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FteditmodalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
