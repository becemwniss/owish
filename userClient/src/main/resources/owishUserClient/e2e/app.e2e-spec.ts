import { OwishUserClientPage } from './app.po';

describe('owish-user-client App', function() {
  let page: OwishUserClientPage;

  beforeEach(() => {
    page = new OwishUserClientPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
