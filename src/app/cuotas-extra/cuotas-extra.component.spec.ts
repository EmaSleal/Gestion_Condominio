import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CuotasExtraComponent } from './cuotas-extra.component';

describe('CuotasExtraComponent', () => {
  let component: CuotasExtraComponent;
  let fixture: ComponentFixture<CuotasExtraComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CuotasExtraComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CuotasExtraComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
