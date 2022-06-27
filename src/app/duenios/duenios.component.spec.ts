import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DueniosComponent } from './duenios.component';

describe('DueniosComponent', () => {
  let component: DueniosComponent;
  let fixture: ComponentFixture<DueniosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DueniosComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DueniosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});


