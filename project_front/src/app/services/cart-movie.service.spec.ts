import { TestBed } from '@angular/core/testing';

import { CartMovieService } from './cart-movie.service';

describe('CartMovieService', () => {
  let service: CartMovieService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CartMovieService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
