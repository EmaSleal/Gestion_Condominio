import { TestBed } from '@angular/core/testing';

import { CuotasExtraService } from './cuotas-extra.service';

describe('CuotasExtraService', () => {
  let service: CuotasExtraService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CuotasExtraService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
