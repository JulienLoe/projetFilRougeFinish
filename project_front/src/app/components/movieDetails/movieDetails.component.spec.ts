import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MovieDetailsComponent } from './movieDetails.component';

describe('DetailsComponent', () => {
  let component: MovieDetailsComponent;
  let fixture: ComponentFixture<MovieDetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MovieDetailsComponent]
    });
    fixture = TestBed.createComponent(MovieDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
