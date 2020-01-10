import { AuthorizeSignatory } from './../../../core/models/Purchase/authorize-signatory';
import { Component, OnInit } from '@angular/core';
import { NzModalService, NzMessageService } from 'ng-zorro-antd';
import { AuthSignAddModalComponent } from './components/auth-sign-add-modal/auth-sign-add-modal.component';
import { AuthSignEditModalComponent } from './components/auth-sign-edit-modal/auth-sign-edit-modal.component';
import { AuthorizeLvlService } from 'src/app/core/services/Purchase/authorize-lvl.service';
import { AuthorizeSignatoryService } from 'src/app/core/services/Purchase/authorize-signatory.service';

@Component({
  selector: 'app-authorize-signatory',
  templateUrl: './authorize-signatory.component.html',
  styleUrls: ['./authorize-signatory.component.less']
})
export class AuthorizeSignatoryComponent implements OnInit {

	authSignatories: any = [];
	loading: boolean = false;
	constructor(private modalSvc: NzModalService,
		private authSignService: AuthorizeSignatoryService,
		private message: NzMessageService) { }

  ngOnInit() {
		this.getAllAuthSign();
  }
  onModalCancel() {
			this.getAllAuthSign();
	}
	onAdd() {
		const modal = this.modalSvc.create({
			nzTitle: "Add Authorize Signatory",
			nzContent: AuthSignAddModalComponent,
			nzOnCancel: this.onModalCancel.bind(this),
			nzOnOk: this.onModalCancel.bind(this),
			nzComponentParams: {
				// feeTypes: this.feeTypes\

			},
			nzFooter: null
		});
		// modal.afterClose.subscribe(this.afterAdd);
	}



	onEdit(authorizeSign: AuthorizeSignatory) {
		const modal = this.modalSvc.create({
			nzTitle: "Edit Authorize Signatory",
			nzContent: AuthSignEditModalComponent,
			nzOnCancel: this.onModalCancel.bind(this),
			nzOnOk: this.onModalCancel.bind(this),
			// nzAfterOpen: this.abc.bind(this),
			nzComponentParams: {
				authSign: authorizeSign
			},
			nzFooter: null
		});
		// modal.afterClose.subscribe(this.afterEdit);
		// modal.afterOpen.subscribe(()=>

		// 	console.log(this.authLvls));
	}

	public getAllAuthSign(){
		this.authSignService.getAllAuthSign().subscribe(
				data => {
						this.authSignatories = data;


				},
				error => {
					if(error['status']=='404'){
						this.authSignatories = [];
					}
						else if(error.error){
						this.authSignatories = error.error;
				}

					else{
						this.loading = true;
					}

				}
		);
	}

	public deleteAuthSign(id: number){
		this.authSignService.deleteAuthSign(id).subscribe(
			data =>{
				this.message.create('success', `Authorize Signatory Deleted Successfully!`);
				this.getAllAuthSign();
			},
			error=> {
				this.message.create('error', `Authorize Signatory Not Deleted!`);
				this.getAllAuthSign();
			}
		);

	}


}
